"use client"

import { CreateInputRequest } from "@/src/dtos/createInputRequest";
import { createInput, findAllInputs } from "@/src/services/inputs.service";
import { Pencil, Plus, Search, Trash } from "lucide-react";
import { useState } from "react";
import { useLoading } from "../context/LoadingContext";
import { Input } from "@/src/types/input.type";

export default function Inputs() {
    const { setLoading } = useLoading()

    const [open, setOpen] = useState(false)
    const [form, setForm] = useState<CreateInputRequest>({
        inputCode: 0,
        name: "",
        quantityInStock: 0
    })
    const [inputs, setInputs] = useState<Input[]>([])
    const [input, setInput] = useState<Input>({
        id: 0,
        inputCode: 0,
        name: "",
        quantityInStock: 0
    })

    async function getAllInputs() {
        try {
            setLoading(true)
            const response = await findAllInputs()
            setInputs(response.inputs)
            console.log(response)
        } finally{
            setLoading(false)
        }
    }

    async function handleSubmit(e: React.FormEvent<HTMLFormElement>) {
       try{
            setLoading(true)
            e.preventDefault()
            
            await createInput(form);
       } finally {
            setLoading(false)
       }
    }

    function handleChange(e: React.ChangeEvent<HTMLInputElement>) {
        setForm({
            ...form,
            [e.target.name]: e.target.value
        })
    }

    return (
        <>
            <div className="flex h-screen p-8 items-start justify-center font-sans bg-gray-1000 pt-10">
                <main className="w-full flex flex-col justify-start">
                    <h1 className="font-bold text-4xl">Inputs</h1>
                    <div className="flex gap-4 ml-auto">
                        <button onClick={() => setOpen(true)} className="mb-4 ml-auto px-4 py-2 bg-gray-400 rounded-md hover:bg-gray-800 transition-all duration-200 text-white flex items-center cursor-pointer">
                            <Plus fill="currentColor" size={16} className="inline-block mr-2" />
                            <span>New Input</span>
                        </button>
                        <button onClick={getAllInputs} className="mb-4 ml-auto px-4 py-2 bg-gray-400 rounded-md hover:bg-gray-800 transition-all duration-200 text-white flex items-center cursor-pointer">
                            <Search fill="currentColor" size={16} className="inline-block mr-2" />
                            <span>Refresh Inputs</span>
                        </button>
                    </div>
                    <div className="overflow-hidden rounded-md">
                        <table className="w-full">
                            <thead className="bg-gray-800 border border-gray-400 border-collapse">
                                <tr>
                                    <th className="p-4 text-left text-gray-100">Code</th>
                                    <th className="p-4 text-left text-gray-100">Name</th>
                                    <th className="p-4 text-left text-gray-100">Stock</th>
                                    <th className="p-4 text-right text-gray-100">Actions</th>
                                </tr>
                            </thead>
                            <tbody className="bg-gray-900 border border-gray-400 border-collapse">
                                {
                                    inputs.length === 0 ? (
                                        <tr>
                                            <td colSpan={4} className="p-8 text-center text-gray-400">
                                                Nenhum input encontrado
                                            </td>
                                        </tr>
                                    ) : (
                                        inputs?.map((input, index) => {
                                            return (
                                                <tr key={index}>
                                                    <td className="p-4">{input.inputCode}</td>
                                                    <td className="p-4">{input.name}</td>
                                                    <td className="p-4">{input.quantityInStock}</td>
                                                    <td className="p-4 flex gap-6 justify-end">
                                                        <Pencil onClick={() => { setOpen(true); setInput(input)}} fill="currentColor" size={16} className="hover:opacity-5 transition-all duration-200 cursor-pointer" />
                                                        <Trash fill="currentColor" size={16} className="hover:opacity-5 transition-all duration-200 cursor-pointer" />
                                                    </td>
                                                </tr>
                                            )
                                        })
                                    )
                                }
                            </tbody>
                            <tfoot className="bg-gray-800 border border-gray-400 border-collapse">
                                <tr>
                                    <td className="p-6 text-gray-100 text-xs" colSpan={4}>Total de {inputs.length} insumos</td>
                                </tr>
                            </tfoot>
                        </table>
                    </div>
                </main>
            </div>
            {open && (
                <div className="fixed inset-0 bg-black/50 flex items-center justify-center z-50">
                    <div className="bg-gray-900 p-6 rounded-xl w-[400px] border border-gray-400">
                        <h2 className="text-xl mb-4">Novo Input</h2>
                        <form onSubmit={handleSubmit}>
                            <input
                                name="inputCode"
                                type="text"
                                value={input.inputCode}
                                onChange={handleChange}
                                placeholder="Código do input"
                                className="w-full p-2 mt-2 mb-4 rounded-md bg-gray-800 border border-gray-400"
                            />
                            <input
                                name="name"
                                type="text"
                                value={input.name}
                                onChange={handleChange}
                                placeholder="Nome do input"
                                className="w-full p-2 mt-2 mb-4 rounded-md bg-gray-800 border border-gray-400"
                            />
                            <input
                                name="quantityInStock"
                                type="number"
                                value={input.quantityInStock}
                                onChange={handleChange}
                                placeholder="Quantidade em estoque"
                                className="w-full p-2 mt-2 mb-4 rounded-md bg-gray-800 border border-gray-400"
                            />

                            <div className="flex justify-end gap-4">
                                <button
                                    onClick={() => setOpen(false)}
                                    className="px-4 py-2 bg-gray-700 hover:bg-gray-600 rounded-md cursor-pointer"
                                >
                                    Cancelar
                                </button>

                                <button type="submit" className="px-4 py-2 bg-blue-600 hover:bg-blue-400 cursor-pointer rounded-md">
                                    Salvar
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
            )}
        </>

    );
}