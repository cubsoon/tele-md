import { SignatureDto } from './signature-dto'

export class ConsultationListItemDto {
	id: string;
    version: number;
	title: string;
	created: SignatureDto;
}