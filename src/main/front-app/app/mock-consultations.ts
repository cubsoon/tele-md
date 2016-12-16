import { Consultation } from './consultation';

export const CONSULTATIONS: Consultation[] = [
	{id: 1, title: 'Konsultacja 1', 
	desc: 'Opis konsultacji 1 Opis konsultacji 1 Opis konsultacji 1 Opis konsultacji 1 Opis konsultacji 1 Opis konsultacji 1 Opis konsultacji 1 Opis konsultacji 1 Opis konsultacji 1 Opis konsultacji 1 Opis konsultacji 1 Opis konsultacji 1 Opis konsultacji 1', 
	date_of_creation: '01/02/2016', creator_id:101, lock: 'locked',
	posts: [{creator_id:101, content: "Post pierwszy", image_url:"jakistamadres"}, {creator_id:100, content: "Post drugi", image_url:"jakistamadres"}]
	},
	
	{id: 2, title: 'Konsultacja 2', 
	desc: 'Opis konsultacji 2', 
	date_of_creation: '11/05/2016', creator_id:100, lock: 'unlocked',
	posts: [{creator_id:100, content: "Post pierwszy", image_url:"jakistamadres"}]
	},
	
	{id: 3, title: 'Konsultacja 3', 
	desc: 'Opis konsultacji 3', 
	date_of_creation: '01/12/2016', creator_id:101, lock: 'locked',
	posts: [{creator_id:101, content: "Post pierwszy", image_url:"jakistamadres"}]
	},
];