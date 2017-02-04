import { Post } from './post'

export class Consultation {
	id: string;
	title: string;
	desc: string;
	date_of_creation: string;
	creator_id: number;
	lock: string;
	posts: Post[];
}