import { Component, Input } from '@angular/core';
import { Router }   from '@angular/router';

@Component({
  	selector: 'new-consultation',

  	styles: [`
    div {
      display: inline-block;
      margin-top: 5%;
      margin-left: 15%;
      background-color: #EEE;
      border-radius: 4px 4px 4px 4px;
      padding: .5em .5em .5em .5em;
    }
  	`],

  	template: `
    <div>
      <label>Tytuł:</label>
      <input type="text" name="title"><td>
      <label>Opis:</label></td>
      <textarea rows="5" cols="60" name="content"></textarea><td>
      <button>Stwórz sesję</button>
    </div>
  	`
})

export class NewConsultationComponent {
}