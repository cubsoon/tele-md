import { Injectable } from '@angular/core';

import { Consultation } from './consultation';
import { CONSULTATIONS } from './mock-consultations';

@Injectable()
export class ConsultationService {
  	getConsultations(): Promise<Consultation[]> {
    	return Promise.resolve(CONSULTATIONS);
  	}
}