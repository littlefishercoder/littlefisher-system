/**
 * Created by littlefisher on 2017/2/1.
 */

import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {FormsModule} from "@angular/forms";
import {BrowserModule} from "@angular/platform-browser";
import {HttpModule} from "@angular/http";

@NgModule({
  imports : [
    CommonModule
  ],
  exports : [
    CommonModule,
    FormsModule,
    BrowserModule,
    HttpModule
  ]
})

export class SharedModule {

}
