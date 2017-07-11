import { MojeCcaPage } from './app.po';

describe('moje-cca App', function() {
  let page: MojeCcaPage;

  beforeEach(() => {
    page = new MojeCcaPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
