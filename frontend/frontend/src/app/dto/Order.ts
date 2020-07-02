import { Item } from "./Item";

export class Order{
    id:number;
    purchaserName: string;
    address:string;
    status:number;
    items:Item[];
}