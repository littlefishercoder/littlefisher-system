/**
 * Created by littlefisher on 2017/1/31.
 */

import {UserLoginComponent} from "./user-login/user-login.component";


export const userRoutes = [
  {
    path : '',
    redirectTo : 'login',
    pathMatch : 'full'
  },
  {
    path : 'login',
    component: UserLoginComponent
  }
]
