/**
 * Created by littlefisher on 2017/1/25.
 */
import {Inject} from "@angular/core";
import {Http, Response} from "@angular/http";
import {Observable} from "rxjs";
import {Attr} from "./attr-model";


@Inject
export class AttrService {
  public attrJsonUrl: string = 'app/attr/attr.json';

  constructor(public http:Http){}

  public getAttrList():Observable<Attr> {
    return this.http.get(this.attrJsonUrl).map((res: Response) => res.json())
  }
}
