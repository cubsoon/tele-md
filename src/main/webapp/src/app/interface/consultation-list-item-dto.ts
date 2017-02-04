import { SignatureDto } from './signature-dto'

import { Consultation } from '../consultation'

export class ConsultationListItemDto {

	toConsultation() {
		let consultation = new Consultation();
		consultation.title = this.title;
		consultation.date_of_creation = this.signature.timestamp.toDateString();
		consultation.creator_id = this.signature.user.id;
		consultation.lock = 'PUBLIC';
		consultation.posts = [];
		return new Consultation;
	}

	id: number;
    version: number;
	title: string;
	signature: SignatureDto
}