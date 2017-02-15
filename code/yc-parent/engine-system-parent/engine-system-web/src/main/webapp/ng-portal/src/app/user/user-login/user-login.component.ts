/**
 * Created by littlefisher on 2017/1/29.
 */

import {UserLoginService} from "./services/user-login.service";
import {Router} from "@angular/router";
import {User} from "../model/user-model";
import {OnInit, Component} from "@angular/core";

@Component({
  selector: 'user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.scss']
})
export class UserLoginComponent implements OnInit {
  public user:User = new User();
  public error : Error;

  constructor(
    public router: Router,
    public userLoginService: UserLoginService
  ) { }
  ngOnInit() {}

  public doLogin(): void {
    this.userLoginService.login().subscribe(
      () => {
        this.router.navigateByUrl('portal');
      },
      error => {
        this.error = error.message;
      }
    );
  }
}
