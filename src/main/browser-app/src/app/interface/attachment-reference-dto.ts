import { SignatureDto } from './signature-dto'

export class AttachmentReferenceDto {
    id: string;
    version: number;
    type: string;
    uploaded: SignatureDto;
}