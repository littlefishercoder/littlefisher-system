import {ErrorHandler, NgModule} from '@angular/core';
/**
 * Created by littlefisher on 2017/2/21.
 */
export class DefaultErrorHandler implements ErrorHandler {
  handleError(error: any): void {
    console.log(error);
  }
}

@NgModule({
  providers: [
    {
      provide: ErrorHandler,
      useClass: DefaultErrorHandler
    }
  ]
})
export class DefaultErrorModule {

}
