/**
 * Created by littlefisher on 2017/1/27.
 */
import {OnInit, Component} from "@angular/core";

@Component({
  selector: 'portal',
  templateUrl: './portal.component.html',
  styleUrls: ['./portal.component.scss']
})
export class PortalComponent implements OnInit {

  constructor() {

  }
  ngOnInit() {
    console.log("PortalComponent init...");
  }
}
