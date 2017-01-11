import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Params }   from '@angular/router';
import { Location }                 from '@angular/common';

import { Consultation } from './consultation';

@Component({
  selector: `playarea`,
  templateUrl: './playarea.component.html',
  styleUrls: ['./playarea.component.css']
})
export class PlayareaComponent implements OnInit {

  abstract;

  @Input consultation: Consultation;

  ngOnInit():void {

  }

}
