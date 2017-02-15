/**
 * Created by littlefisher on 2017/1/29.
 */

import {Http} from "@angular/http";
import {User} from "../../model/user-model";
import {Subject, Observable} from "rxjs";
import {Injectable} from "@angular/core";

@Injectable()
export class UserLoginService {
  public userLoginURL:string =  "app/user/user-login/services/user-login.json";
  public subject: Subject<User> = new Subject<User>();

  constructor(public http: Http) {
  }

  public getCurrentUser() : Observable<User> {
    return this.subject.asObservable();
  }

  public login() {
    console.log("user login service login...");
    return this.http.get(this.userLoginURL).map(
      res => {
        let user = res.json();
        if (user && user.token) {
          localStorage.setItem("currentUser", JSON.stringify(user));
          this.subject.next(Object.assign({}, user));
        }
        return res;
      });
  }

  public logout(): void {
    console.log("user login service logout...");
    //退出登录移除
    localStorage.removeItem("currentUser");
    this.subject.next(Object.assign({}));
  }
}
