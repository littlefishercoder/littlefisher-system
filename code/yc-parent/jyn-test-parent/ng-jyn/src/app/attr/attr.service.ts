/**
 * Created by littlefisher on 2017/2/16.
 */

import {Injectable} from '@angular/core';
import {Http, Response} from '@angular/http';
import {Observable} from 'rxjs';
import {Attr} from './model/attr-model';

import 'rxjs/Rx';

@Injectable()
export class AttrService {

  public attrListUrl = 'http://127.0.0.1:80/jyn-test-web/api/v1/jyn/attr';

  constructor(public http: Http) {

  }

  public getAttrList(): Observable<Attr[]> {
    return this.http.get(this.attrListUrl)
      .map(
        (res: Response) => {
          return res.json();
        },
        (error: any) => {
          console.log(error);
        }
      )
      .catch(
        (error: any) => {
          console.log(error);
          return Observable.throw(error || 'Server error');
        }
      );
  }
}
