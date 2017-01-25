import { Component } from '@angular/core';
import {AttrService} from "./attr/attr.service";

import {Attr} from "./attr/attr-model";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  public attrList: Attr[];
  constructor(
    public attrService: AttrService
  ) {

  }

  ngOnInit () {
    this.getAttrList();
  }

  getAttrList () {
    this.attrService.getAttrList().subscribe(
      attrs => this.attrList = attrs
    );
  }
}
