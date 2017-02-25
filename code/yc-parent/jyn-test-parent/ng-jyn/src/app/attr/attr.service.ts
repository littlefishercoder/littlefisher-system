/**
 * Created by littlefisher on 2017/2/16.
 */

import {Injectable} from '@angular/core';
import {Http, Response} from '@angular/http';
import {Observable} from 'rxjs/Observable';
import {Attr} from './model/attr-model';

import 'rxjs/Rx';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';
import {rootUrl} from '../share/root-url';

@Injectable()
export class AttrService {

  public attrListUrl = rootUrl + 'api/v1/jyn/attr';

  constructor(public http: Http) {

  }

  public getAttrList(): Observable<Attr[]> {
    return this.http.get(this.attrListUrl)
      .map(
        res => res.json()
      )
      .catch(
        error => {
          debugger;
          const errMsg = error.message;
          console.log(errMsg);
          return Observable.throw(error);
        }
      );
  }
}
