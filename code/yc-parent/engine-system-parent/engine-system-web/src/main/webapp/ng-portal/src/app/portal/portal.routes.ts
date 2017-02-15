import {PortalComponent} from "./portal.component";
/**
 * Created by littlefisher on 2017/1/31.
 */

export const portalRoutes = [
  {
    path : '',
    redirectTo : 'main',
    pathMatch : 'full'
  },
  {
    path : 'main',
    component: PortalComponent,
    children : [{
      path : '',
      loadChildren : '../attr/attr.module#AttrModule'
    }]
  }
]
