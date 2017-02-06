export class InstantDto {
	epochSecond: number;
    get date(): number {
        return this.epochSecond * 1000;
    };
}