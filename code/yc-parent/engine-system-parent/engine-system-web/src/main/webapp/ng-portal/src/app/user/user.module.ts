/**
 * Created by littlefisher on 2017/1/31.
 */

import {NgModule} from "@angular/core";
import {UserLoginService} from "./user-login/services/user-login.service";
import {RouterModule} from "@angular/router";
import {userRoutes} from "./user.routes";
import {UserLoginComponent} from "./user-login/user-login.component";
import {CommonModule} from "@angular/common";
import {FormsModule} from "@angular/forms";

@NgModule({
  declarations: [
    UserLoginComponent
  ],
  imports : [
    CommonModule,
    FormsModule,
    RouterModule.forChild(userRoutes)
  ],
  providers: [
    UserLoginService
  ]
})

export class UserModule {

}
