import { Component } from '@angular/core';
import {AttrService} from "./attr/attr.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  public attr: Attr;
  constructor(
    public attrService: AttrService
  ) {

  }

  ngOnInit () {
    this.attrService.getAttrList()
  }
}
