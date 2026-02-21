import { api } from "@/lib/axios";
import { CreateInputRequest } from "../dtos/createInputRequest";
import { Input } from "../types/input.type";

export async function createInput(req: CreateInputRequest): Promise<Input>{
    const response = await api.post("/inputs", req)
    return response.data;
}

export async function findAllInputs(): Promise<{inputs: Input[]}>{
    const response = await api.get("/inputs")
    return response.data;
}

export async function bindInput(codeOrName: string): Promise<Input>{
    const response = await api.get("/inputs/bind", {
        params: {
            codeOrName
        }
    })
    return response.data;
}