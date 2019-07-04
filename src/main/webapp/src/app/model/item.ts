export class Item {
    constructor(id, name, description, amount) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.amount = amount;
    }
    id: string;
    name: string;
    description: string;
    amount:number;
}
