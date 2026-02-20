import { Pencil, Plus, Trash } from "lucide-react";
import Link from "next/link";

export default function Products() {
    const products = [
        {
            id: 1,
            code: "001",
            name: "Product 1",
            price: "10,00"
        }
    ]

    return (
        <div className="flex min-h-screen items-start justify-center font-sans bg-gray-1000">
            <main className="w-full p-8 flex flex-col justify-start">
                <h1 className="font-bold text-4xl">Products</h1>
                <Link href={`/products/new`} className="ml-auto px-4 py-2 bg-gray-400 rounded-md hover:bg-gray-800 transition-all duration-200 text-white flex items-center cursor-pointer">
                    <Plus fill="currentColor" size={16} className="inline-block mr-2"/>
                    <span>New Product</span>
                </Link>
                <div className="overflow-hidden rounded-md mt-8">
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
                                products.length === 0 ? (
                                    <tr>
                                        <td colSpan={4} className="p-8 text-center text-gray-400">
                                            Nenhum produto encontrado
                                        </td>
                                    </tr>
                                ) : (
                                    products.map((product, index) => {
                                        return (
                                            <tr key={index}>
                                                <td className="p-4">{product.code}</td>
                                                <td className="p-4">{product.name}</td>
                                                <td className="p-4">{product.price}</td>
                                                <td className="p-4 flex gap-6 justify-end">
                                                        
                                                    <Link href={`/products/${product.id}`}>
                                                        <Pencil href="/" fill="currentColor" size={16} className="hover:opacity-5 transition-all duration-200 cursor-pointer"/>
                                                    </Link>
                                                    <Trash fill="currentColor" size={16} className="hover:opacity-5 transition-all duration-200 cursor-pointer"/>
                                                </td>
                                            </tr>
                                        )
                                    })
                                )
                            }
                        </tbody>
                        <tfoot className="bg-gray-800 border border-gray-400 border-collapse">
                            <tr>
                                <td className="p-6 text-gray-100 text-xs" colSpan={4}>Total de {products.length} produtos </td>
                            </tr>
                        </tfoot>
                    </table>
                </div>
            </main>
        </div>
    );
}