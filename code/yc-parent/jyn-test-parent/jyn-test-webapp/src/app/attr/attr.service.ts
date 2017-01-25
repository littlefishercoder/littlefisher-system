import { Injectable } from '@angular/core';
import {Http, Response} from "@angular/http";
import {Observable} from "rxjs";
import 'rxjs/add/operator/map';
import {Attr} from "./attr-model";


@Injectable()
export class AttrService {
  public attrJsonUrl: string = 'app/attr/attr.json';

  constructor(public http:Http){}

  public getAttrList():Observable<Attr[]> {
    return this.http.get(this.attrJsonUrl).map((res: Response) => res.json());
  }

}
