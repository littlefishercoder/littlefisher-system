import { NgJynTestPage } from './app.po';

describe('ng-jyn-test App', () => {
  let page: NgJynTestPage;

  beforeEach(() => {
    page = new NgJynTestPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
