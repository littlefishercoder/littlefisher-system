/**
 * Created by littlefisher on 2017/2/1.
 */


import {NgModule} from "@angular/core";
import {RouterModule} from "@angular/router";
import {attrRoutes} from "./attr.routes";
import {AttrListComponent} from "./attr-list/attr-list.component";
@NgModule({
  declarations : [
    AttrListComponent
  ],
  imports : [
    RouterModule.forChild(attrRoutes)
  ],
  providers : [

  ]
})

export class AttrModule {

}
