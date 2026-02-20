"use client"

import { ArrowLeft, Disc, Info, Plus, Save, Trash } from "lucide-react"
import { useRouter } from "next/navigation"

export default function Product() {
    const router = useRouter()

    const inputs = [
        {
            code: "001",
            name: "Input 1",
            stock: "10,00"
        }
    ]
    return(
        <div className="h-screen bg-gray-1000 p-8 flex flex-col justify-start gap-6">
            <div className="flex content-between items-center">
                <button className="cursor-pointer hover:opacity-5 transition-all duration-200" onClick={() => router.back()}>
                    <ArrowLeft />
                </button>
                <button className="ml-auto px-4 py-2 bg-gray-400 rounded-md hover:bg-gray-800 transition-all duration-200 text-white flex items-center cursor-pointer">
                    <Save fill="currentColor" size={16} className="inline-block mr-2"/>
                    <span>Save Product</span>
                </button>
            </div>
            <div className="grid grid-cols-[1fr_2fr] gap-4 items-start font-sans bg-gray-1000">
                <div className="bg-blue-1000 rounded-xl border border-gray-400 flex flex-col items-center gap-6 justify-center p-8">
                    <span className="flex gap-4 align-baseline">
                        <Info fill="#60a5fa" color="#FFF"/>
                        <h2 className="text-gray-100">Informações Gerais</h2>
                    </span>
                    <fieldset className="w-full">
                        <legend className="text-gray-100 text-sm mb-2">Código</legend>
                        <input placeholder="Digite o código do produto..." type="text" className="w-full bg-blue-800 rounded-md border border-gray-400 p-2 text-sm text-gray-100 focus:outline-none focus:ring-2 focus:ring-blue-500 focus:border-transparent"/>
                    </fieldset>
                    <fieldset className="w-full">
                        <legend className="text-gray-100 text-sm mb-2">Nome</legend>
                        <input placeholder="Digite o nome do produto..." type="text" className="w-full bg-blue-800 rounded-md border border-gray-400 p-2 text-sm text-gray-100 focus:outline-none focus:ring-2 focus:ring-blue-500 focus:border-transparent"/>
                    </fieldset>
                    <fieldset className="w-full">
                        <legend className="text-gray-100 text-sm mb-2">Preço</legend>
                        <input placeholder="Digite o preço do produto..." type="text" className="w-full bg-blue-800 rounded-md border border-gray-400 p-2 text-sm text-gray-100 focus:outline-none focus:ring-2 focus:ring-blue-500 focus:border-transparent"/>
                    </fieldset>

                </div>
                <div className="flex flex-col gap-4">
                    <div className="bg-blue-1000 rounded-xl border border-gray-400 flex flex-col gap-6 items-center justify-center">
                        <span className="flex gap-4 align-baseline mt-4">
                            <h2 className="text-gray-100">Receitas de composição</h2>
                        </span>

                        <table className="w-full">
                            <thead className="bg-blue-800 border border-gray-400 border-collapse">
                                <tr>
                                    <th className="p-4 text-left text-gray-100">Code</th>
                                    <th className="p-4 text-left text-gray-100">Name</th>
                                    <th className="p-4 text-left text-gray-100">Stock</th>
                                    <th className="p-4 text-right text-gray-100">Actions</th>
                                </tr>
                            </thead>
                            <tbody className="bg-blue-1000 border border-gray-400 border-collapse">
                                {
                                    inputs.map((input, index) => {
                                        return (
                                            <tr key={index}>
                                                <td className="p-4">{input.code}</td>
                                                <td className="p-4">{input.name}</td>
                                                <td className="p-4">{input.stock}</td>
                                                <td className="p-4 flex gap-6 justify-end">
                                                    <Trash fill="currentColor" size={16} className="hover:opacity-5 transition-all duration-200 cursor-pointer"/>
                                                </td>
                                            </tr>
                                        )
                                    })
                                }
                            </tbody>
                            <tfoot className="bg-blue-800 rounded-md">
                                <tr>
                                    <td className="p-6 text-gray-100 text-xs" colSpan={4}>Total de {inputs.length} produtos </td>
                                </tr>
                            </tfoot>
                        </table>
                    </div>

                    <div className="col-start-2 bg-blue-1000 rounded-xl border border-gray-400 flex flex-col gap-4 items-start justify-start p-4 min-h-25">
                        <span className="flex gap-4 align-baseline">
                            <h2 className="text-gray-100">Vincular Insumos</h2>
                        </span>
                        <div className="w-full grid grid-cols-[4fr_1fr]">
                            <input type="text" className="bg-blue-800 rounded-md border border-gray-400 p-2 text-sm text-gray-100 focus:outline-none focus:ring-2 focus:ring-blue-500 focus:border-transparent" placeholder="Digite o nome ou código do insumo..."/>
                            <button className="bg-blue-800 hover:bg-blue-600 cursor-pointer transition-all duration-200 text-white px-4 py-2 rounded-md ml-2">Vincular</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}