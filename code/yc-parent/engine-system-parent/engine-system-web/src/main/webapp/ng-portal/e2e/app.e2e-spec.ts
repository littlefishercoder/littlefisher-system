import { NgPortalPage } from './app.po';

describe('ng-portal App', function() {
  let page: NgPortalPage;

  beforeEach(() => {
    page = new NgPortalPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
