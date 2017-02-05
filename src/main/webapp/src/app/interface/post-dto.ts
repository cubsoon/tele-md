import { SignatureDto } from './signature-dto';
import { ImageDto } from './image-dto';

export class PostDto {
	id: string;
	version: number;
	image: ImageDto;
	added: SignatureDto;
	content: string;
}