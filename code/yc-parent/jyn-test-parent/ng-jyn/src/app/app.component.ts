import {Component, OnInit} from '@angular/core';
import {AttrService} from './attr/attr.service';
import {Attr} from './attr/model/attr-model';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  public attrList: Array<Attr>;

  constructor(public attrService: AttrService) {}

  ngOnInit(): void {
    this.attrService.getAttrList().subscribe(
      data => {
        this.attrList = data;
      },
      error => {
        console.log(error);
      }
    );
  }
}
