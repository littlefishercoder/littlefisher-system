/**
 * Created by littlefisher on 2017/1/31.
 */

import {NgModule} from "@angular/core";
import {PortalComponent} from "./portal.component";
import {RouterModule} from "@angular/router";
import {portalRoutes} from "./portal.routes";
import {CommonModule} from "@angular/common";
import {AttrModule} from "../attr/attr.module";

@NgModule({
  declarations : [
    PortalComponent
  ],
  imports : [
    CommonModule,
    RouterModule.forChild(portalRoutes)
  ],
  providers : [
  ]
})

export class PortalModule {

}
