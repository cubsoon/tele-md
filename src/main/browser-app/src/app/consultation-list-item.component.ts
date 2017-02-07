import { Component, Input, OnInit } from '@angular/core';

import { ConsultationListItemDto } from './interface/consultation-list-item-dto'
import { SignatureDto } from './interface/signature-dto';
import { InstantDto } from './interface/instant-dto'

@Component({
	selector: `consultation-list-item`,
	styles: [`
        li {
            cursor: pointer;
            position: relative;
            left: 0;
            background-color: #EEE;
            margin: .5em;
            padding: .3em .3em .3em;
            height: 5%;
            border-radius: 4px;
        }
        li.selected:hover {
            background-color: #BBD8DC !important;
            color: white;
        }
        li:hover {
            color: #607D8B;
            background-color: #DDD;
            left: .1em;
        }
        .text {
            position: relative;
            top: -3px;
        }
        .title {
            display: inline-block;
            font-size: 20px;
            color: white;
            padding: 0.8em 0.7em 0 0.7em;
            background-color: #607D8B;
            line-height: 1em;
            position: relative;
            left: -1px;
            top: -4px;
            height: 1.8em;
            margin-right: .8em;
            margin-top: .2em;
            border-radius: 4px 4px 4px 4px;
        }
        .creator {
            display: inline-block;
            font-size: 10px;
            color: white;
            padding: 0.8em 0.7em 0 0.7em;
            background-color: #607D8B;
            line-height: 1em;
            position: relative;
            left: -1px;
            top: -4px;
            height: 1.8em;
            margin-right: .8em;
            border-radius: 4px 4px 4px 4px;
        }
        .description{
            word-break: normal;
            display: block;
            margin: .5em .5em .8em .5em;
        }
        a .description {
            color: black;
        }
        a {
            text-decoration: none;
        }
        .date {
            display: inline-block;
            float: right;
            font-size: 10px;
            color: white;
            padding: 0.8em 0.7em 0 0.7em;
            background-color: #607D8B;
            line-height: 1em;
            position: relative;
            left: -1px;
            top: -4px;
            height: 1.8em;
            border-radius: 4px 4px 4px 4px;
        }
        .lockpad{
            float: right;
            display: inline-block;
            width:124px;
            height:72px;
        }
	`],
	template: `
    <a [routerLink]="['/detail', item.id]"  class="col-1-4">
        <li>
            <span class="title">{{item.title}}</span>
            <img class="lockpad" src="assets/unlocked.png" alt=unlocked>
            <span class="description">Opis: {{item.description}}</span>
            <span class="creator">{{item.created.user?.username}}</span>
            <span class="date">Data utworzenia: {{item.created.timestamp.epochSecond * 1000 | date:'medium'}}</span>
        </li>
    </a>   
	`
})
export class ConsultationListItemComponent {
	
    @Input()
    private item: ConsultationListItemDto;

}
