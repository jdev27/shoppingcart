import { CartItemDTO } from './cart-item';

export class CartDTO {
    constructor() {
        this.cartItems = [];
    }
    createDate: string;
    cartItems: CartItemDTO[];
}
