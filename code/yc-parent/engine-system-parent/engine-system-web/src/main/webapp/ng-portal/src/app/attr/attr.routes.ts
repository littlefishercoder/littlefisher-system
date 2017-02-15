import {AttrListComponent} from "./attr-list/attr-list.component";
/**
 * Created by littlefisher on 2017/2/1.
 */

export const attrRoutes = [
  {
    path : '',
    redirectTo : 'attrlist',
    pathMatch:'full'
  },
  {
    path : 'attrlist',
    component: AttrListComponent
  }
]
