import { Deserializable } from './Deserializable';

export class Movie implements Deserializable{
    public name: string;
    public desc: string;
    public rating: number;

    deserialize(input: any): this {
        return Object.assign(this, input);
    }
}