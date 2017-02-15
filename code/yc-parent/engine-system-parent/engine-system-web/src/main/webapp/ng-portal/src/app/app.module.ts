
import { RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';

import { appRoutes } from './app.routes';

import { AppComponent } from './app.component';
import {SharedModule} from "./shared/shared.module";

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    SharedModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
