

export class Action {
  id: string;
  signature: Signature;
  desc: string;
  date_of_creation: string;
  creator_id: number;
  lock: string;
  posts: Post[];
}
