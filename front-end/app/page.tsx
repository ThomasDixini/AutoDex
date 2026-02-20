import { Plus, Save, Search } from "lucide-react";

export default function Home() {
  const products = [
    {
      code: "001",
      name: "Product 1",
      total: "10,00",
      capacity: "3"
    }
  ]
  return (
    <div className="flex h-screen p-8 items-start justify-center font-sans bg-gray-1000 pt-10">
      <main className="w-full p-8 flex flex-col gap-6 justify-start">
        <h1 className="font-bold text-4xl">Production</h1>
        <button className="ml-auto px-4 py-2 bg-gray-400 rounded-md hover:bg-gray-800 transition-all duration-200 text-white flex items-center cursor-pointer">
          <Search fill="currentColor" size={16} className="inline-block mr-2"/>
          <span>Search</span>
        </button>
        <div className="grid grid-cols-[1fr_2fr] gap-4 items-start font-sans bg-gray-1000">
          <div className="bg-blue-1000 rounded-xl border border-gray-400 flex flex-col items-center gap-6 justify-center p-4">
            <span className="flex gap-4 items-center">
              <div className="bg-blue-400 rounded-full p-1">
                <Plus fill="#60a5fa" color="#0a0c10" size={16} />
              </div>
              <h2 className="text-blue-400 font-bold">Nova Produção</h2>
            </span>

            <fieldset className="w-full">
              <legend className="text-gray-100 text-sm mb-2">Produto</legend>
              <select className="appearance-none w-full bg-blue-800 text-gray-100 p-2 rounded-md border border-gray-400">
                <option>Selecione uma opção</option>
                <option value="1">Produção 1</option>
                <option value="2">Produção 2</option>
              </select>
            </fieldset>
            
            <fieldset className="w-full">
              <legend className="text-gray-100 text-sm mb-2">Quantidade</legend>
              <input placeholder="Quantidade a ser produzida..." type="text" className="w-full bg-blue-800 rounded-md border border-gray-400 p-2 text-sm text-gray-100 focus:outline-none focus:ring-2 focus:ring-blue-500 focus:border-transparent"/>
            </fieldset>

            <button className="w-full bg-blue-600 hover:bg-blue-400 transition-all duration-200 cursor-pointer py-4 px-4 rounded-md">
              Confirmar Produção
            </button>
          </div>
          <div className="bg-blue-1000 rounded-xl border border-gray-400 flex flex-col gap-6 items-center justify-center">
            <span className="flex gap-4 align-baseline mt-4">
                <h2 className="text-gray-100">Produtos para produção</h2>
            </span>

            <table className="w-full">
                <thead className="bg-blue-800 border border-gray-400 border-collapse">
                    <tr>
                        <th className="p-4 text-center text-gray-100">Code</th>
                        <th className="p-4 text-center text-gray-100">Name</th>
                        <th className="p-4 text-center text-gray-100">Capacity</th>
                        <th className="p-4 text-center text-gray-100">Total</th>
                    </tr>
                </thead>
                <tbody className="bg-blue-1000 border border-gray-400 border-collapse">
                    {
                        products.map((product, index) => {
                            return (
                                <tr key={index}>
                                    <td className="p-4 text-center">{product.code}</td>
                                    <td className="p-4 text-center">{product.name}</td>
                                    <td className="p-4 text-center">{product.capacity}</td>
                                    <td className="p-4 text-center">{product.total}</td>
                                </tr>
                            )
                        })
                    }
                </tbody>
                <tfoot className="bg-blue-800 rounded-md">
                    <tr>
                        <td className="p-6 text-gray-100 text-xs" colSpan={4}>Total de {products.length} produtos </td>
                    </tr>
                </tfoot>
            </table>
          </div>
        </div>
      </main>
    </div>
  );
}
