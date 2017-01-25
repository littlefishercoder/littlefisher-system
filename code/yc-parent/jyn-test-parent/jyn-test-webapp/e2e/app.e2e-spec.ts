import { JynTestWebappPage } from './app.po';

describe('jyn-test-webapp App', function() {
  let page: JynTestWebappPage;

  beforeEach(() => {
    page = new JynTestWebappPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
