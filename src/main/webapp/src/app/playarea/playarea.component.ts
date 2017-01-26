import { Component, Input, OnInit } from '@angular/core';
import { Router }            from '@angular/router';
import { Observable }        from 'rxjs/Observable';
import { Subject }           from 'rxjs/Subject';

import { Consultation }     from '../consultation';
import { Action }           from './action';
import { PlayareaService }  from './playarea.service';

@Component({
  selector: `playarea`,
  templateUrl: './playarea.component.html',
  styleUrls: [ './playarea.component.css' ],
  providers: [ PlayareaService ]
})
export class PlayareaComponent implements OnInit {

  abstract;

  constructor(
    private playareaService: PlayareaService,
    private router : Router
  ) { }

  @Input() consultationId: String;

  ngOnInit():void {

  }

}
