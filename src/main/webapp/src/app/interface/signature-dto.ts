import { UserDto } from './user-dto';
import { InstantDto } from './instant-dto';

export class SignatureDto {
	user: UserDto;
    timestamp: InstantDto;
}