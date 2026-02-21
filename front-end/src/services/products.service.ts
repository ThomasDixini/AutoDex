import { api } from "@/lib/axios";
import { CreateProductRequest } from "../dtos/createProductRequest";
import { Product } from "../types/product.type";



export async function createProduct(req: CreateProductRequest){
    console.log(req)
    const response = await api.post("/products", req)
    return response.data;
}

export async function getProductsCapacity(){
    const response = await api.get("/products/production-capacity")
    return response.data;
}

export async function findAllProducts(): Promise<{products: Product[]}>{
    const response = await api.get("/products")
    return response.data;
}