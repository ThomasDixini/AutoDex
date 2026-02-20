import { api } from "@/lib/axios";
import { CreateProductRequest } from "../dtos/createProductRequest";



export async function createProduct(req: CreateProductRequest){
    const response = await api.post("/products", req)
    return response.data;
}

export async function getProductsCapacity(){
    const response = await api.get("/products/production-capacity")
    return response.data;
}