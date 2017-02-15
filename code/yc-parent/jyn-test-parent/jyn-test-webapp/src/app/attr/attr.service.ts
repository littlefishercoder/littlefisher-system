import { Injectable } from '@angular/core';
import {Http, Response} from "@angular/http";
import {Observable} from "rxjs";
import 'rxjs/add/operator/map';
import {Attr} from "./attr-model";


@Injectable()
export class AttrService {
  public attrUrl: string = 'http://127.0.0.1:80/jyn-test-web/api/v1/jyn/attr';

  constructor(public http:Http){}

  public getAttrList():Observable<Attr[]> {
    return this.http.get(this.attrUrl).map((res: Response) => res.json());
  }

}
