/**
 * Created by littlefisher on 2017/1/27.
 */


export const appRoutes = [
  {
    path : '',
    redirectTo : 'user',
    pathMatch : 'full'
  },
  {
    path: 'portal',
    loadChildren: './portal/portal.module#PortalModule'
  },
  {
    path: 'user',
    loadChildren: './user/user.module#UserModule'
  }
]
