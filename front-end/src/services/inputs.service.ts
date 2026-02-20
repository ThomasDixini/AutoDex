import { api } from "@/lib/axios";
import { CreateInputRequest } from "../dtos/createInputRequest";

export async function createInput(req: CreateInputRequest){
    const response = await api.post("/inputs", req)
    return response.data;
}