import { PostDto } from './post-dto'
import { SignatureDto } from './signature-dto'

export class ConsultationDto {
	id: string;
    version: number;
	title: string;
	created: SignatureDto;
	posts: PostDto[];
}