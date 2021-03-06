package com.littlefisher.core.mybatis.pagehelper;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;

import com.github.pagehelper.Page;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.littlefisher.core.common.utils.CollectionUtil;

/**
 * 对Page结果进行包装
 * <p/>
 * 新增分页的多项属性，主要参考:http://bbs.csdn.net/topics/360010907
 *
 * @author liuzh/abel533/isea533
 * @version 3.3.0
 * @since 3.2.2 项目地址 : http://git.oschina.net/free/Mybatis_PageHelper
 */
public class PageInfo<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    /** 当前页 */
    private int pageNum;
    /** 每页的数量 */
    private int pageSize;
    /** 当前页的数量 */
    private int size;

    /** 当前页面第一个元素在数据库中的行号 */
    private int startRow;
    /** 当前页面最后一个元素在数据库中的行号 */
    private int endRow;
    /** 总记录数 */
    private long total;
    /** 总页数 */
    private int pages;
    /** 结果集 */
    private List<T> list;

    /** 前一页 */
    private int prePage;
    /** 下一页 */
    private int nextPage;

    /** 是否为第一页 */
    private boolean isFirstPage = false;
    /** 是否为最后一页 */
    private boolean isLastPage = false;
    /** 是否有前一页 */
    private boolean hasPreviousPage = false;
    /** 是否有下一页 */
    private boolean hasNextPage = false;
    /** 导航页码数 */
    private int navigatePages;
    /** 所有导航页号 */
    private int[] navigatePageNums;
    /** 导航条上的第一页 */
    private int navigateFirstPage;
    /** 导航条上的最后一页 */
    private int navigateLastPage;

    public PageInfo() {}

    /**
     * 包装Page对象
     *
     * @param list 集合
     */
    public PageInfo(List<T> list) {
        this(list, 8);
    }

    /**
     * 对{@link PageInfo#list}进行转换，转换方式使用function
     *
     * @param pageInfo 原pageInfo，用于提取除list以外的所有信息
     * @param function 转换逻辑
     * @param <F> 泛型
     */
    public <F> PageInfo(PageInfo<F> pageInfo, final Function<? super F, ? extends T> function) {
        setPageInfoFields(pageInfo);
        this.setList(Lists.newArrayList(Iterators.transform(pageInfo.getList().iterator(), function::apply)));
    }

    /**
     * 对{@link PageInfo#list}进行转换，直接替换为入参list
     *
     * @param pageInfo 原pageInfo，用于提取除list以外的所有信息
     * @param list 新list
     * @param <F> 泛型
     */
    public <F> PageInfo(PageInfo<F> pageInfo, List<T> list) {
        setPageInfoFields(pageInfo);
        this.setList(list);
    }

    /**
     * 设置除list以外的所有信息
     *
     * @param pageInfo 原pageInfo
     * @param <F> 泛型
     */
    private <F> void setPageInfoFields(PageInfo<F> pageInfo) {
        this.setPageNum(pageInfo.getPageNum());
        this.setPageSize(pageInfo.getPageSize());
        this.setPages(pageInfo.getPages());
        this.setSize(pageInfo.getSize());
        this.setTotal(pageInfo.getTotal());
        this.setStartRow(pageInfo.getStartRow());
        this.setEndRow(pageInfo.getEndRow());
        this.setPrePage(pageInfo.getPrePage());
        this.setNextPage(pageInfo.getNextPage());
        this.setIsFirstPage(pageInfo.isIsFirstPage());
        this.setIsLastPage(pageInfo.isIsLastPage());
        this.setHasPreviousPage(pageInfo.isHasPreviousPage());
        this.setHasNextPage(pageInfo.isHasNextPage());
        this.setNavigatePages(pageInfo.getNavigatePages());
        this.setNavigatePageNums(pageInfo.getNavigatePageNums());
        this.setNavigateFirstPage(pageInfo.getNavigateFirstPage());
        this.setNavigateLastPage(pageInfo.getNavigateLastPage());
    }

    /**
     * 包装Page对象
     *
     * @param list page结果
     * @param navigatePages 页码数量
     */
    public PageInfo(List<T> list, int navigatePages) {
        if (list instanceof Page) {
            Page<T> page = (Page<T>) list;
            this.pageNum = page.getPageNum();
            this.pageSize = page.getPageSize();

            this.pages = page.getPages();
            this.list = page;
            this.size = page.size();
            this.total = page.getTotal();
            // 由于结果是>startRow的，所以实际的需要+1
            if (this.size == 0) {
                this.startRow = 0;
                this.endRow = 0;
            } else {
                this.startRow = page.getStartRow() + 1;
                // 计算实际的endRow（最后一页的时候特殊）
                this.endRow = this.startRow - 1 + this.size;
            }
        } else if (list instanceof Collection) {
            this.pageNum = 1;
            this.pageSize = list.size();

            this.pages = this.pageSize > 0 ? 1 : 0;
            this.list = list;
            this.size = list.size();
            this.total = list.size();
            this.startRow = 0;
            this.endRow = CollectionUtil.isNotEmpty(list) ? list.size() - 1 : 0;
        }
        if (list instanceof Collection) {
            this.navigatePages = navigatePages;
            // 计算导航页
            calcNavigatePageNums();
            // 计算前后页，第一页，最后一页
            calcPage();
            // 判断页面边界
            judgePageBoudary();
        }
    }

    /**
     * 计算导航页
     */
    private void calcNavigatePageNums() {
        // 当总页数小于或等于导航页码数时
        if (pages <= navigatePages) {
            navigatePageNums = new int[pages];
            for (int i = 0; i < pages; i++) {
                navigatePageNums[i] = i + 1;
            }
        }
        // 当总页数大于导航页码数时
        else {
            navigatePageNums = new int[navigatePages];
            int startNum = pageNum - navigatePages / 2;
            int endNum = pageNum + navigatePages / 2;

            if (startNum < 1) {
                startNum = 1;
                // (最前navigatePages页
                for (int i = 0; i < navigatePages; i++) {
                    navigatePageNums[i] = startNum++;
                }
            } else if (endNum > pages) {
                endNum = pages;
                // 最后navigatePages页
                for (int i = navigatePages - 1; i >= 0; i--) {
                    navigatePageNums[i] = endNum--;
                }
            } else {
                // 所有中间页
                for (int i = 0; i < navigatePages; i++) {
                    navigatePageNums[i] = startNum++;
                }
            }
        }
    }

    /**
     * 计算前后页，第一页，最后一页
     */
    private void calcPage() {
        if (navigatePageNums != null && navigatePageNums.length > 0) {
            navigateFirstPage = navigatePageNums[0];
            navigateLastPage = navigatePageNums[navigatePageNums.length - 1];
            if (pageNum > 1) {
                prePage = pageNum - 1;
            }
            if (pageNum < pages) {
                nextPage = pageNum + 1;
            }
        }
    }

    /**
     * 判定页面边界
     */
    private void judgePageBoudary() {
        isFirstPage = pageNum == 1;
        isLastPage = pageNum == pages || pages == 0;
        hasPreviousPage = pageNum > 1;
        hasNextPage = pageNum < pages;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getStartRow() {
        return startRow;
    }

    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }

    public int getEndRow() {
        return endRow;
    }

    public void setEndRow(int endRow) {
        this.endRow = endRow;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    /**
     * @deprecated firstPage就是1, 此函数获取的是导航条上的第一页, 容易产生歧义
     * @return firstPage
     */
    @Deprecated
    public int getFirstPage() {
        return navigateFirstPage;
    }

    @Deprecated
    public void setFirstPage(int firstPage) {
        this.navigateFirstPage = firstPage;
    }

    public int getPrePage() {
        return prePage;
    }

    public void setPrePage(int prePage) {
        this.prePage = prePage;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    /**
     * @deprecated 请用getPages()来获取最后一页, 此函数获取的是导航条上的最后一页, 容易产生歧义.
     * @return lastPage
     */
    @Deprecated
    public int getLastPage() {
        return navigateLastPage;
    }

    @Deprecated
    public void setLastPage(int lastPage) {
        this.navigateLastPage = lastPage;
    }

    public boolean isIsFirstPage() {
        return isFirstPage;
    }

    public void setIsFirstPage(boolean isFirstPage) {
        this.isFirstPage = isFirstPage;
    }

    public boolean isIsLastPage() {
        return isLastPage;
    }

    public void setIsLastPage(boolean isLastPage) {
        this.isLastPage = isLastPage;
    }

    public boolean isHasPreviousPage() {
        return hasPreviousPage;
    }

    public void setHasPreviousPage(boolean hasPreviousPage) {
        this.hasPreviousPage = hasPreviousPage;
    }

    public boolean isHasNextPage() {
        return hasNextPage;
    }

    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    public int getNavigatePages() {
        return navigatePages;
    }

    public void setNavigatePages(int navigatePages) {
        this.navigatePages = navigatePages;
    }

    public int[] getNavigatePageNums() {
        return navigatePageNums;
    }

    public void setNavigatePageNums(int[] navigatePageNums) {
        this.navigatePageNums = navigatePageNums;
    }

    public int getNavigateFirstPage() {
        return navigateFirstPage;
    }

    public int getNavigateLastPage() {
        return navigateLastPage;
    }

    public void setNavigateFirstPage(int navigateFirstPage) {
        this.navigateFirstPage = navigateFirstPage;
    }

    public void setNavigateLastPage(int navigateLastPage) {
        this.navigateLastPage = navigateLastPage;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("PageInfo{");
        sb.append("pageNum=").append(pageNum);
        sb.append(", pageSize=").append(pageSize);
        sb.append(", size=").append(size);
        sb.append(", startRow=").append(startRow);
        sb.append(", endRow=").append(endRow);
        sb.append(", total=").append(total);
        sb.append(", pages=").append(pages);
        sb.append(", list=").append(list);
        sb.append(", prePage=").append(prePage);
        sb.append(", nextPage=").append(nextPage);
        sb.append(", isFirstPage=").append(isFirstPage);
        sb.append(", isLastPage=").append(isLastPage);
        sb.append(", hasPreviousPage=").append(hasPreviousPage);
        sb.append(", hasNextPage=").append(hasNextPage);
        sb.append(", navigatePages=").append(navigatePages);
        sb.append(", navigateFirstPage=").append(navigateFirstPage);
        sb.append(", navigateLastPage=").append(navigateLastPage);
        sb.append(", navigateageNums=");
        if (navigatePageNums == null) {
            sb.append("null");
        } else {
            sb.append('[');
            for (int i = 0; i < navigatePageNums.length; ++i) {
                sb.append(i == 0 ? "" : ", ").append(navigatePageNums[i]);
            }
            sb.append(']');
        }
        sb.append('}');
        return sb.toString();
    }
}
