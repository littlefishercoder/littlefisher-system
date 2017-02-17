import { NgJynPage } from './app.po';

describe('ng-jyn App', function() {
  let page: NgJynPage;

  beforeEach(() => {
    page = new NgJynPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
