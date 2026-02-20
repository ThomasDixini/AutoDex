export interface CreateProductRequest {
    code: string;
    name: string;
    price: number;
    inputs: InputForProductDto[];
}

export interface InputForProductDto {
    inputId: number;
    quantity: number;
}